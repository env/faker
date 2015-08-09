(defproject env/faker "0.3.2-SNAPSHOT"
            :description "Fake data generation for Clojure(script)."
            :url "https://github.com/env/faker"

            :license {:name "The MIT License"
                      :url "http://opensource.org/licenses/MIT"}

            :dependencies [[org.clojure/clojure "1.7.0"]
                           [com.cemerick/url "0.1.1"]]

            :plugins [[com.cemerick/clojurescript.test "0.3.1"]]

            :aliases {"deploy" ["do" "clean," "cljx" "once," "deploy" "clojars"]}

            :jar-exclusions [#"\.cljx|\.swp|\.swo|\.DS_Store"]

            :lein-release {:deploy-via :shell
                           :shell ["lein" "deploy"]}

            :source-paths ["src"])
