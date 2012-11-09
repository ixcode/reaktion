;; For heroku...
;;(mg/connect-via-uri! (System/genenv "MONGOHQ_URL"))

;;(mc/insert "mycollection" { :_id "509d887f3004e23034457a76" :first_name "John" :last_name "Lennon" })

;; (insert-batch "document" [{ :first_name "John" :last_name "Lennon" }
;;                           { :first_name "Paul" :last_name "McCartney" }])

;;(mc/find "mycollection" {:first_name "John"})
;;(mc/find-one "mycollection" {:first_name "John"})
;;(println (str  (:_id (mc/find-map-by-id "mycollection" (ObjectId. "509d887f3004e23034457a76")))))
