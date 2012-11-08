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
  {:der42323234 
    {:is :talk
     :title "The Catcher in the code"
     :speaker "Pavel Badenski"
     :speaker-img "https://secure.gravatar.com/avatar/5c934bb3826efd22dcb43894b817153a?s=400&d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png"}
   :saer3224234123 
    {:is :talk
     :title "Programming in the large"
     :speaker "James Lewis"
     :speaker-img "https://trello-avatars.s3.amazonaws.com/6b2b6c28c5a69c16844d55efe7113bdc/30.png"}})


(defpage "/" []
  (common/layout
   {:title "reaktion - home"}
   [:h1 "Let's get your reaktion"]
   [:div.talk
    [:form {:action "/"}
     [:h2.title "Talk: The Catcher In the code"]
     [:img.speaker {:src "https://secure.gravatar.com/avatar/5c934bb3826efd22dcb43894b817153a?s=400&d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png"
                    :alt "Pawel Badenski"}]
     [:p.speaker "Pavel Badenski"]
     [:p "If you select lower than 3 bytes (will be zeroes and ones) you will need to enter a comment."]     
     ;; [:div.reaktion      
     ;;  (choice-image "reaktion" "zzz" "/img/sleep.jpeg" "Zzzzz")
     ;;  (choice-image "reaktion" "er?" "/img/confused.jpeg" "Er...?")
     ;;  (choice-image "reaktion" "hmm" "/img/bored.jpeg" "Hmmm...?")
     ;;  (choice-image "reaktion" "ok" "/img/ok.jpeg" "Ok")
     ;;  (choice-image "reaktion" "wow" "/img/monumental.jpeg" "Monumental!")]

     [:div.ratings
      [:h2 "Your feedback..."]
      (rating-question "overall-impression")
      (rating-question "presentation-style")
      (rating-question "technical-interest")
      (rating-question "slidewate-quality")
      (rating-question "clarity-of-communication")
      (comment-box "Enter any comments")      
      [:input.btn {:type "submit" :value "REAKT!"}]]]]))
