(ns reaktion.views.index
  (:require [reaktion.views.common :as common])
  (:use noir.core
        hiccup.element))

(defn choice-image [name value src text]
  (let [id (format "%s-%s" name value)]
       [:label {:for id}
        [:input {:id id :type "radio" :name name :value value}]
        [:img.choice {:src src}] text]))

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
     [:ul
      [:li "Presentation style"]
      [:li "Technical interest"]
      [:li "Slideware quality"]
      [:li "Clarity of communication"]]
     [:div.reaktion
      (choice-image "reaktion" "zzz" "/img/sleep.jpeg" "Zzzzz")
      (choice-image "reaktion" "er?" "/img/confused.jpeg" "Er...?")
      (choice-image "reaktion" "hmm" "/img/bored.jpeg" "Hmmm...?")
      (choice-image "reaktion" "ok" "/img/ok.jpeg" "Ok")
      (choice-image "reaktion" "wow" "/img/monumental.jpeg" "Monumental!")]
     [:label "Enter any comments" [:input {:type "text-area"}]]
     [:input {:type "submit" :value "REAKT!"}]]]))
