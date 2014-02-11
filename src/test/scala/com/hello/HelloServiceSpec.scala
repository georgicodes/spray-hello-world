package com.hello

import org.specs2.mutable.Specification
import spray.testkit.Specs2RouteTest
import spray.http._
import StatusCodes._

class HelloServiceSpec extends Specification with Specs2RouteTest with HelloService {
  def actorRefFactory = system
  
  "HelloService" should {

    "return a greeting for GET requests to the root path" in {
      Get() ~> serviceRoute ~> check {
        responseAs[String] must contain("Say hello")
      }
    }

    "leave GET requests to other paths unhandled" in {
      Get("/sparklePrincessPony") ~> serviceRoute ~> check {
        handled must beFalse
      }
    }

    // "return a status OK return code under the /status url" in {
    //   Get("/status") ~> sealRoute(serviceRoute) ~> check {
    //     status === OK
    //   }
    // }

  }
}