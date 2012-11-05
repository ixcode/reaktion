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

(def rating-questions
  ["presentation-style"
   "technical-interest"
   "slideware-quality"
   "clarity-of-communication"])

(defn rating-table [questions]
  )

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
     ;;[:p "If you select lower than 3 bytes (will be zeroes and ones) you will need to enter a comment."]     
     ;; [:div.reaktion      
     ;;  (choice-image "reaktion" "zzz" "/img/sleep.jpeg" "Zzzzz")
     ;;  (choice-image "reaktion" "er?" "/img/confused.jpeg" "Er...?")
     ;;  (choice-image "reaktion" "hmm" "/img/bored.jpeg" "Hmmm...?")
     ;;  (choice-image "reaktion" "ok" "/img/ok.jpeg" "Ok")
     ;;  (choice-image "reaktion" "wow" "/img/monumental.jpeg" "Monumental!")]

     [:div.ratings
      (rating-question "overall-impression")
      (rating-question "presentation-style")
      (rating-question "technical-interest")
      (rating-question "slidewate-quality")
      (rating-question "clarity-of-communication")]


     [:label "Enter any comments" [:textarea.comments]]
     [:input {:type "submit" :value "REAKT!"}]]]))
