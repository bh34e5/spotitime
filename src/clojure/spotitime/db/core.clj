(ns spotitime.db.core
  (:require
    [clojure.edn :as edn]
    [next.jdbc :as jdbc]
    [honey.sql :as sql]
    [spotitime.config :as config]))

(def dbspec (config/get-config :dbspec))
(def datasource (jdbc/get-datasource dbspec))
(def sqlstmt (sql/format {:select [:*] :from [:testing_table]}))

(jdbc/execute! datasource sqlstmt)
