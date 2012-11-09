(ns reaktion.views.index
  (:require [reaktion.views.common :as common]
            [reaktion.data.current_talks :as data]
            [noir.response :as response]
	)
  (:use noir.core
        hiccup.element
        reaktion.views.components))

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
   [:form {:method :post :action (format "/talks/%s" id)}
    [:h2.title title]
    [:img.speaker {:src speaker-img
                   :alt speaker}]
    [:p.speaker speaker]
    
    [:div.ratings
     [:h2 "Your feedback..."]
     (rating-question "overall-impression")
     (rating-question "presentation-style")
     (rating-question "technical-interest")
     (rating-question "slideware-quality")
     (rating-question "clarity-of-communication")
     (comment-box "Enter any comments" "comments")      
     [:input.btn {:type "submit" :value "REAKT!"}]]]])

(defpage [:get "/"] {:as formData}
  (common/layout
   {:title "reaktion - talk"}
   (list-talks data/talk-list)))


(defpage [:get "/talks/:id"] {:keys [id]}
  (common/layout
   {:title "reaktion - talk"}
   (reakt-to-a-talk ((keyword id) data/talk-index))))

(defpage [:post "/talks/:id"] {:as params}
  (println params)
  (response/redirect "/feedback-accepted"))

(defpage [:get "/feedback-accepted"] {}
  (common/layout
   {:title "Thank you"}
   [:h1 "Thanks, your feedback has been submitted!"]
   [:p "Return to "
    [:a {:href "/"} "The list of talks."]]))
