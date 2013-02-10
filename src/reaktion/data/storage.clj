(ns reaktion.data.storage
  (:require [reaktion.data.monger_api :as mongo]))


(defn save-feedback [data]
  (println "Storing Feedback For " (dissoc data :reviewer_email))
  (mongo/store-document "feedback" (dissoc data :reviewer_email)))

(defn retrieve-feedback-for-talk [id]
  (mongo/retrieve-collection "feedback" {:talk id}))

(defn register-reviewer [email date-of-talks]
  (println (format "Registering Reviewer: %s on %s" email date-of-talks))
  (mongo/store-document "reviewers" {:date date-of-talks :email email}))

(defn pick-email-at-random-from [seq]
  (let [entry (rand-nth seq)]
    (let [{:keys [email id]} entry]
      (if (empty? email)
        (format "the email entry (%s) is blank" id)
        email))))

(defn choose-winner [date-of-event]
  (println "Picking a winner for the event date of " date-of-event)
  (pick-email-at-random-from (mongo/retrieve-collection "reviewers" {:date date-of-event})))
