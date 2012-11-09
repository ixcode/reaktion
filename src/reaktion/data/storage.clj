(ns reaktion.data.storage
  (:require [reaktion.data.monger_api :as mongo]))


(defn save-feedback [data]
  (println "Storing Feedback: " data)
  (mongo/store-document "feedback" (dissoc data :reviewer_email)))

(defn register-reviewer [email date-of-talks]
  (println (format "Registering Reviewer: %s on %s" email date-of-talks))
  (mongo/store-document "reviewers" {:date date-of-talks :email email}))