(ns spotitime.web.core
  (:require
    [org.httpkit.server :as hk-server]
    [compojure.core :refer :all]
    [compojure.route :as route]))

(defroutes my-routes
  (GET "/foo" [] "Hello foo")
  (GET "/bar" request (str "Hello" request))
  (route/not-found "<h1>Page not found</h1>"))

(def my-server (hk-server/run-server #'my-routes {:port 8080}))

(comment
  ;; run to stop the server
  (my-server))
