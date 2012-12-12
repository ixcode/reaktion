(ns reaktion.data.current_talks)

;; To generate UUIDS :  (str (java.util.UUID/randomUUID))

(defn talk-1 [host]
  {:is :talk
   :id "572073e3-5676-4f3f-bdfb-0912a2973737"
   :self (format "http://%s/talks/572073e3-5676-4f3f-bdfb-0912a2973737" host)
   :title "The Catcher in the code"
   :speaker "Pawel Badenski"
   :speaker-img "https://secure.gravatar.com/avatar/5c934bb3826efd22dcb43894b817153a?s=400&d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png"
   :feedback (format "http://%s/talks/572073e3-5676-4f3f-bdfb-0912a2973737/feedback" host)})

(defn talk-2 [host]
  {:is :talk
   :id "cf549313-bf03-4231-b17d-1be56ae13bb8"
   :self (format "http://%s/talks/cf549313-bf03-4231-b17d-1be56ae13bb8" host)
   :title "The Data and the Data - Techniques and consequences from the rise of online data visualisation."
   :speaker "Gareth Rogers"
   :speaker-img "http://www.cartoonlogodesigns.com/images/misc/Smiley%20faces/smiley%20face.jpg"
   :feedback (format "http://%s/talks/cf549313-bf03-4231-b17d-1be56ae13bb8/feedback" host)})

(defn talk-3 [host uuid]
  {:is :talk
   :id uuid
   :self (format "http://%s/talks/%s" host uuid)
   :title "The Data and the Data - Techniques and consequences from the rise of online data visualisation."
   :speaker "Gareth Rogers"
   :speaker-img "http://www.cartoonlogodesigns.com/images/misc/Smiley%20faces/smiley%20face.jpg"
   :feedback (format "http://%s/talks/%s/feedback" host uuid)})


(defn talk-4 [host uuid]
  {:is :talk
   :id uuid
   :self (format "http://%s/talks/%s" host uuid)
   :title "Programming in the large"
   :speaker "James Lewis"
   :speaker-img "https://trello-avatars.s3.amazonaws.com/6b2b6c28c5a69c16844d55efe7113bdc/original.png"
   :feedback (format "http://%s/talks/%s/feedback" host uuid)})


(defn talk-list [host]
  [(talk-3 host "ddd03ec4-d9f9-4d9d-a86e-8b171f774d06") (talk-4 host "63b59404-6c77-481d-8aa3-872996f5019f")])

(defn to-entry [item]  [(keyword (item :id)) item])

(defn talk-index [host]
  (into {} (map to-entry (talk-list host))))

;; or - (apply hash-map (flatten (map to-entry (talk-list host))))





