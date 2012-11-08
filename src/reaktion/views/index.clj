(ns reaktion.views.index
  (:require [reaktion.views.common :as common])
  (:use noir.core
        hiccup.element))

(defn label-from-id [id]
  (-> 
   (clojure.string/replace id "-" " ")
   (clojure.string/capitalize)))


(defn choice-image [name value src text]
  (let [id (format "%s-%s" name value)]
       [:label {:for id}
        [:input {:id id :type "radio" :name name :value value}]
        [:img.choice {:src src}] text]))


(defn radio-button [id name value]  
  [:input {:id name :type "radio" :name name :value value}])

(defn rating-radio-button [question-id value]
  (let [element-id (format "%s_%s" (clojure.string/replace question-id "-" "_") value)]
    (radio-button element-id (clojure.string/replace question-id "-" ".") value)))

(defn rating-question [question-id]
  [:p.rating-question
   [:span.label (label-from-id question-id)]
   [:span.low "low"]
   (rating-radio-button question-id "01")
   (rating-radio-button question-id "02")
   (rating-radio-button question-id "03")
   (rating-radio-button question-id "04")
   (rating-radio-button question-id "05")
   [:span.high "high"]])

(defn comment-box [title]
  [:div.comment-box
   [:label "Enter any comments" [:textarea.comments]]])

(def talk-data
   
  [{:is :talk
     :title "The Catcher in the code"
     :speaker "Pavel Badenski"
     :speaker-img "https://secure.gravatar.com/avatar/5c934bb3826efd22dcb43894b817153a?s=400&d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png"},
    
    {:is :talk
     :title "Programming in the large"
     :speaker "James Lewis"
     :speaker-img "https://trello-avatars.s3.amazonaws.com/6b2b6c28c5a69c16844d55efe7113bdc/30.png"}])


(defpartial reakt-to-a-talk [{:keys [id title speaker speaker-img]}]
  
  [:h1 "Let's get your reaktion"]
  [:div.talk
   [:form {:action (format "/talks/%s" id)}
    [:h2.title title]
    [:img.speaker {:src speaker-img
                   :alt speaker}]
    [:p.speaker speaker]
    
    [:div.ratings
     [:h2 "Your feedback..."]
     (rating-question "overall-impression")
     (rating-question "presentation-style")
     (rating-question "technical-interest")
     (rating-question "slidewate-quality")
     (rating-question "clarity-of-communication")
     (comment-box "Enter any comments")      
     [:input.btn {:type "submit" :value "REAKT!"}]]]])

(defpage [:get "/"] {}
  (common/layout
   {:title "reaktion - home"}
   (reakt-to-a-talk (first talk-data))))
