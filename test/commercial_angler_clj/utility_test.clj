(ns commercial-angler-clj.utility-test
  (:require [commercial-angler-clj.utility
             :refer [str->int str->decimal] :as utility :as utility]
            [clojure.test :refer :all]))

(deftest test-str->int
  (testing "Testing utility/str->int."
    (is (= 0 (utility/str->int "0")))
    (is (= nil (utility/str->int "a")))
    (is (= nil (utility/str->int "-")))
    (is (= nil (utility/str->int "9.1")))
    (is (= -1 (utility/str->int "-1")))
    (is (= 1 (utility/str->int "01")))))

(deftest test-str->decimal
  (testing "Testing utility/str->decimal."
    (is (= 0.01 (utility/str->decimal "0.01")))
    (is (= nil (utility/str->decimal "a")))
    (is (= nil (utility/str->decimal "-")))
    (is (= nil (utility/str->decimal "9")))
    (is (= nil (utility/str->decimal "01.0001")))
    (is (= -1.1 (utility/str->decimal "-1.1")))
    (is (= 1.01 (utility/str->decimal "01.01")))))

(deftest test-apply-schema
  (testing "Testing utility/apply-schema."
    (let [schema [{:a 'identity} {:b 'str->int}]
          data {:a "hello" :b "3"}]
      (is (= {:a "hello" :b 3} (utility/apply-schema schema data))))))
