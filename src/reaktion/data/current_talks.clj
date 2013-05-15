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

(defn talk-5 [host uuid]
  {:is :talk
   :id uuid
   :self (format "http://%s/talks/%s" host uuid)
   :title "Patterns for Continuous Delivery"
   :speaker "Pat Kua"
   :speaker-img "https://s3.amazonaws.com/avatars.leanpub.com/avatars/4877/medium/PatKua.jpg?1327680860"
   :feedback (format "http://%s/talks/%s/feedback" host uuid)})


(defn talk-6 [host uuid]
  {:is :talk
   :id uuid
   :self (format "http://%s/talks/%s" host uuid)
   :title "Deployment Patterns - Blue/Green, Canary, Phoenix, and their friends"
   :speaker "Kief Morris"
   :speaker-img "https://trello-avatars.s3.amazonaws.com/6cafe0128b1bc15acf95b0d2c8199b77/original.png"
   :feedback (format "http://%s/talks/%s/feedback" host uuid)})

(defn talk-7 [host uuid]
  {:is :talk
   :id uuid
   :self (format "http://%s/talks/%s" host uuid)
   :title "Sourcecode in Slides - a little tool to make life easier"
   :speaker "Johannes Thönes"
   :speaker-img "https://trello-avatars.s3.amazonaws.com/2aa2d4764b7c513f51d9ceb3aa842744/original.png"
   :feedback (format "http://%s/talks/%s/feedback" host uuid)})

(defn talk-8 [host uuid]
  {:is :talk
   :id uuid
   :self (format "http://%s/talks/%s" host uuid)
   :title "Lightning talks - the rematch"
   :speaker "session led by Jennifer Smith"
   :speaker-img "https://trello-avatars.s3.amazonaws.com/2146f9034db00f562da532cd9721c2aa/original.png"
   :feedback (format "http://%s/talks/%s/feedback" host uuid)})

(defn talk-9 [host uuid]
  {:is :talk
   :id uuid
   :self (format "http://%s/talks/%s" host uuid)
   :title "Building a Hackintosh"
   :speaker "Erik Doernenburg"
   :speaker-img "https://trello-avatars.s3.amazonaws.com/dcbecc7f0daf6d55a1e6e7b59da88360/original.png"
   :feedback (format "http://%s/talks/%s/feedback" host uuid)
   })

(defn talk-10 [host uuid]
  {:is :talk
   :id uuid
   :self (format "http://%s/talks/%s" host uuid)
   :title "How we test our heavy UI bits over at ChessCasting"
   :speaker "Christoph Burgmer"
   :speaker-img "https://trello-avatars.s3.amazonaws.com/e9af4da95560a09b7a484c0d8c34694d/original.png"
   :feedback (format "http://%s/talks/%s/feedback" host uuid)
   })

(defn talk-11 [host uuid]
  {:is :talk
   :id uuid
   :self (format "http://%s/talks/%s" host uuid)
   :title "flatMap for fun and profit"
   :speaker "Aleksander Sumowski"
   :speaker-img "https://en.gravatar.com/userimage/2643580/33ee26d4a41d9d4b4dee14b7a5bdd874.jpg?size=200"
   :feedback (format "http://%s/talks/%s/feedback" host uuid)
   })

(defn talk-12 [host uuid]
  {:is :talk
   :id uuid
   :self (format "http://%s/talks/%s" host uuid)
   :title "Building cross-platform mobile apps with Calatrava"
   :speaker "Giles Alexander"
   :speaker-img "https://trello-avatars.s3.amazonaws.com/99b1488f5b731ffb6bb2323eff5de959/original.png"
   :feedback (format "http://%s/talks/%s/feedback" host uuid)
   })

(defn talk-13 [host uuid]
  {:is :talk
   :id uuid
   :self (format "http://%s/talks/%s" host uuid)
   :title "Making pictures with code that you'd almost consider hanging on your wall."
   :speaker "John Cowie"
   :speaker-img "https://trello-avatars.s3.amazonaws.com/6936e621b6067b42db6735f7eaa54869/original.png"
   :feedback (format "http://%s/talks/%s/feedback" host uuid)
   })

(defn talk-14 [host uuid]
  {:is :talk
   :id uuid
   :self (format "http://%s/talks/%s" host uuid)
   :title "Fun with graphs"
   :speaker "Jen Smith"
   :speaker-img "https://trello-avatars.s3.amazonaws.com/2146f9034db00f562da532cd9721c2aa/original.png"
   :feedback (format "http://%s/talks/%s/feedback" host uuid)
   })


(println (java.util.UUID/randomUUID))

(defn talk-list [host]
  [(talk-13 host "4610aabd-a615-4a85-bbc8-10293d9e0adb")
   (talk-14 host "366f6a9b-7311-4a21-9aae-5ff55c6e0bb7")])

(defn to-entry [item]  [(keyword (item :id)) item])

(defn talk-index [host]
  (into {} (map to-entry (talk-list host))))



;; or - (apply hash-map (flatten (map to-entry (talk-list host))))
