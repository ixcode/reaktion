(ns reaktion.views.index
  (:require [reaktion.data.current_talks :as data]
            [reaktion.data.storage :as storage]
            [reaktion.views.enlive_helpers :as enlive]
            [compojure.response :as response]
            )
  (:use compojure.core
        [noir.response :only [json redirect]]
        reaktion.views.components))

(defn hostname [server port]
    (format "%s:%s" server, port))

(defn index [server port]
  (enlive/render (enlive/talks (data/talk-list (hostname server port)))))

(defn door-prize [server port]
  (enlive/render (enlive/door-prize (hostname server port))))


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
