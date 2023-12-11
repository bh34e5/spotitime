(ns spotitime.config
  (:require
    [clojure.edn :as edn]
    [clojure.java.io :as io]))

(def ^:private config-var ::unloaded)
(defn- get-instance []
  (if (= ::unloaded config-var)
    (let [c (edn/read-string (slurp (io/resource "config.edn")))]
      (def config-var c)
      c)
    config-var))

(defn get-config [config-key]
  (let [inst (get-instance)]
    (get inst config-key)))
