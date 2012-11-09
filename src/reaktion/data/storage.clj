(ns reaktion.data.storage)

(defn save-feedback [data]
  (println "Feedback: " data))

(defn register-reviewer [email date-of-talks]
  (println (format "Registering Reviewer: %s on %s" email date-of-talks)))