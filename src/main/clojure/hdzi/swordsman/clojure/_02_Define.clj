(ns hdzi.swordsman.clojure.-02-Define)

;;; 定义全局变量
;; def 定义的变量全局有效
(def x 1)

;;; 定义函数
;; 一般定义
(defn greeting                                              ;; 函数名
  "Return say \"Hello, someone\""                           ;; 函数文档(可以不写)
  [name]                                                    ;; 参数
  (str "Hello!" name))                                      ;; 函数体
;; 多函数体实现
(defn greeting2
  ([] (greeting2 "world"))                                  ;;实现1
  ([name] (str "Hello!" name)))                             ;;实现2

;; 不定参数
(defn sum [& params]
  (reduce #'+ params))

;; 匿名函数
(def my-inc (fn [x] (+ 1 x)))
(def my-inc2 #(+ 1 %))                                      ;; 省略参数: 单参数 %; 多参数 %1 %2 ...

;; 本地变量
(let [a 1
      b 2
      c 3]
  (+ a b c))