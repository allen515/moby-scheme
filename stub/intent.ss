#lang scheme/base
(require lang/prim)

(define (execute-intent action data)
  (printf "start intent with action ~a and data ~a" action data))     

(provide-primitive execute-intent)