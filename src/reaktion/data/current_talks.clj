(ns reaktion.data.current_talks)

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
   :title "Building micro services using Java, Gradle and Dropwizard"
   :speaker "David Morgantini"
   :speaker-img "http://www.cartoonlogodesigns.com/images/misc/Smiley%20faces/smiley%20face.jpg"
   :feedback (format "http://%s/talks/cf549313-bf03-4231-b17d-1be56ae13bb8/feedback" host)})

(defn talk-list [host]
  [(talk-1 host) (talk-2 host)])

(defn talk-index [host]
  {:572073e3-5676-4f3f-bdfb-0912a2973737 (talk-1 host)
   :cf549313-bf03-4231-b17d-1be56ae13bb8 (talk-2 host)})
