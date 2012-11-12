(ns reaktion.data.current_talks)

(def talk-1
  {:is :talk
   :id "572073e3-5676-4f3f-bdfb-0912a2973737"
   :title "The Catcher in the code"
   :speaker "Pavel Badenski"
   :speaker-img "https://secure.gravatar.com/avatar/5c934bb3826efd22dcb43894b817153a?s=400&d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png"
   :feedback "http://localhost:8080/talks/572073e3-5676-4f3f-bdfb-0912a2973737/feedback"})

(def talk-2
  {:is :talk
   :id "cf549313-bf03-4231-b17d-1be56ae13bb8"
   :title "Programming in the large"
   :speaker "James Lewis"
   :speaker-img "https://trello-avatars.s3.amazonaws.com/6b2b6c28c5a69c16844d55efe7113bdc/30.png"
   :feedback "http://localhost:8080/talks/cf549313-bf03-4231-b17d-1be56ae13bb8/feedback"})

(def talk-list
  [talk-1 talk-2])

(def talk-index {:572073e3-5676-4f3f-bdfb-0912a2973737 talk-1
                 :cf549313-bf03-4231-b17d-1be56ae13bb8 talk-2})