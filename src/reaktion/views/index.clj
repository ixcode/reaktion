(ns reaktion.views.index
  (:require [reaktion.views.common :as common]
            [reaktion.data.current_talks :as data]
            [reaktion.data.storage :as storage]
            [reaktion.views.enlive_helpers :as enlive]
            [compojure.response :as response]
            )
  (:use compojure.core
        hiccup.element
        [noir.response :only [json redirect]]
        hiccup.def
        reaktion.views.components))

(defn hostname [server port]
    (format "%s:%s" server, port))


(defhtml talk-item [{:keys [id title speaker speaker-img]}]
  [:li
   [:p.talk-list-item    
    [:img.speaker {:src speaker-img} ]
    [:a {:href (format "/talks/%s" id)} title]] ])

(defhtml list-talks [talks]
  [:h1 "Here are the talks you can reakt to..."]
  [:ul
   (map talk-item talks)])

(defhtml reakt-to-a-talk [{:keys [id title speaker speaker-img]}]
  
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


(defn index [server port]
  (enlive/render (enlive/talks (data/talk-list (hostname server port)))))


(defn talks [server port]
  (json (data/talk-list (hostname server port))))

(defn talk_feedback [id]
  (json (storage/retrieve-feedback-for-talk id)))


(defn talk_feedback_form [id server port]
  (enlive/render (enlive/talk-reaktion ((keyword id) (data/talk-index (hostname server port))))))

(defn feedback_accepted []
  (enlive/render (enlive/feedback-accepted)))

(defn save_feedback [params]
  (storage/save-feedback (dissoc params :id))
  (storage/register-reviewer (:reviewer_email params) "07-02-2013")
  (redirect "/feedback-accepted")
 )


(defn ping [request]
  (json (merge {:is :ping :message "pong"} (:params request))))
