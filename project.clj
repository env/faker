(defproject env/faker "0.3.1-SNAPSHOT"
            :description "Fake data generation for Clojure(script)."
            :url "https://github.com/env/faker"

            :license {:name "The MIT License"
                      :url "http://opensource.org/licenses/MIT"}

            :dependencies [[org.clojure/clojure "1.7.0-beta2"]
                           [org.clojure/clojurescript "0.0-3269"]
                           [com.cemerick/url "0.1.1"]]

            :plugins [[lein-cljsbuild "1.0.3"]
                      [com.cemerick/clojurescript.test "0.3.1"]]

            :prep-tasks [["cljx" "once"] "javac" "compile"]

            :cljx {:builds [{:source-paths ["src"]
                             :output-path "target/generated/src/clj"
                             :rules :clj}
                            {:source-paths ["src"]
                             :output-path "target/generated/src/cljs"
                             :rules :cljs}
                            {:source-paths ["test"]
                             :output-path "target/generated/test/clj"
                             :rules :clj}
                            {:source-paths ["test"]
                             :output-path "target/generated/test/cljs"
                             :rules :cljs}]}

            :profiles {:dev {:dependencies [[prismatic/schema "0.3.2"]]

                             :plugins [[com.keminglabs/cljx "0.5.0"]
                                       [com.cemerick/clojurescript.test "0.3.1"]]}}

            :aliases {"deploy" ["do" "clean," "cljx" "once," "deploy" "clojars"]
                      "test" ["do" "clean," "cljx" "once," "test," "with-profile" "dev" "cljsbuild" "test"]}

            :jar-exclusions [#"\.cljx|\.swp|\.swo|\.DS_Store"]

            :lein-release {:deploy-via :shell
                           :shell ["lein" "deploy"]}

            :source-paths ["target/generated/src/clj" "src"]

            :resource-paths ["target/generated/src/cljs"]

            :test-paths ["target/generated/test/clj" "test"]

            :cljsbuild {:test-commands {"unit" ["phantomjs" :runner
                                                "window.literal_js_was_evaluated=true"
                                                "target/unit-test.js"]}

                        :builds
                        {:test {:source-paths ["src" "test"
                                               "target/generated/src/cljs"
                                               "target/generated/test/cljs"]
                                :compiler {:output-to "target/unit-test.js"
                                           :optimizations :whitespace}}}})