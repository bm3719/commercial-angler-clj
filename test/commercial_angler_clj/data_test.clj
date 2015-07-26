(ns commercial-angler-clj.data-test
  (:require [commercial-angler-clj.data :as data]
            [clojure.test :refer :all]))

(deftest test-get-by-id
  (testing "Testing data/get-by-id."
    (is (= {:id 1 :a 2} (data/get-by-id [{:id 1 :a 2}] 1)))
    (is (= nil (data/get-by-id [{:id 1 :a 2}] 2)))))
