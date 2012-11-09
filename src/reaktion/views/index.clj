(ns reaktion.views.index
  (:require [reaktion.views.common :as common]
            [reaktion.data.current_talks :as data]
            [reaktion.views.components :as components])
  (:use noir.core
        hiccup.element))

(defpartial talk-item [{:keys [id title speaker speaker-img]}]
  [:li
   [:p.talk-list-item    
    [:img.speaker {:src speaker-img} ]
    [:a {:href (format "/talks/%s" id)} title]] ])

(defpartial list-talks [talks]
  [:h1 "Here are the talks you can reakt to..."]
  [:ul
   (map talk-item talks)])

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
     (components/rating-question "overall-impression")
     (components/rating-question "presentation-style")
     (components/rating-question "technical-interest")
     (components/rating-question "slidewate-quality")
     (components/rating-question "clarity-of-communication")
     (components/comment-box "Enter any comments")      
     [:input.btn {:type "submit" :value "REAKT!"}]]]])

(defpage [:get "/"] {:as formData}
  (common/layout
   {:title "reaktion - talk"}
   (list-talks data/talk-data)))


(defpage [:get "/talks/:id"] {:keys [id]}
  (common/layout
   {:title "reaktion - talk"}
   (reakt-to-a-talk (first data/talk-data))))

