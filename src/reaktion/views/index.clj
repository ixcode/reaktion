(ns reaktion.views.index
  (:require [reaktion.views.common :as common]
            [reaktion.data.current_talks :as data]
            [reaktion.data.storage :as storage]
            [reaktion.views.enlive_helpers :as enlive]
            [noir.request :as request]
            [noir.response :as response])
  (:use noir.core
        hiccup.element
        reaktion.views.components))

(defn hostname []
  (let [{ server :server-name port :server-port} (request/ring-request)]
    (format "%s:%s" server, port)))


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
  [:p.instructions "Although we ask for your email, it's only used for the door prize, the feedback will be annonymous, promise!"]
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
     (email-question "reviewer-email")
     [:input {:type "hidden" :name "talk" :value id}]
     [:input.btn {:type "submit" :value "REAKT!"}]]]])

(defpage [:get "/"] {:as formData}
  (common/layout
   {:title "reaktion - talk"}
   (list-talks (data/talk-list (hostname)))))


(defpage [:get "/talks"] {:as formData}  
  (println (hostname))
  (response/json (data/talk-list (hostname))))

(defpage [:get "/talks/:id/feedback"] {:keys [id]}
  (response/json (storage/retrieve-feedback-for-talk id)))

(defpage [:get "/talks/:id"] {:keys [id]}
  (common/layout
   {:title "reaktion - talk"}
   (reakt-to-a-talk ((keyword id) (data/talk-index (hostname))))))


(defpage [:post "/talks/:id"] {:as params}
  (storage/save-feedback (dissoc params :id))
  (storage/register-reviewer (:reviewer_email params) "14-11-2012")
  (response/redirect "/feedback-accepted"))



(defpage [:get "/feedback-accepted"] {}
  (common/layout
   {:title "Thank you"}
   [:h1 "Thanks, your feedback has been submitted and you have been entered for the door prize. Your email address will not be associated with the feedback."]
   [:p "Return to "
    [:a {:href "/"} "The list of talks."]]))


(defpage [:get "/ping"] {:as params}
  (println request/ring-request)
  (response/json (merge {:is :ping :message "pong"} params)))

(defpage [:get "/try-enlive"] {:as params}
  (enlive/render (enlive/talks "hello")))
  