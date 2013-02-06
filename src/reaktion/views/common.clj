(ns reaktion.views.common
  (:use [hiccup.def :only [defhtml]]
        [hiccup.page :only [include-css html5]]))

(defhtml layout [params & content]
            (html5
              [:head
               [:title (:title params)]
               (include-css "/css/site.css")]
              [:body
               [:div#wrapper
                content]]))
