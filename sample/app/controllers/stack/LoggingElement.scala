package controllers.stack

import javax.inject.Inject

import jp.t2v.lab.play2.stackc.{RequestWithAttributes, StackableController}
import play.api.Logger
import play.api.mvc.{AbstractController, InjectedController, Result}

@Inject
trait LoggingElement extends StackableController {
    self: AbstractController =>

  override def cleanupOnSucceeded[A](req: RequestWithAttributes[A], res: Option[Result]): Unit = {
      res.map { result =>
        Logger.debug(Array(result.header.status, req.toString(), req.body).mkString("\t"))
      }
      super.cleanupOnSucceeded(req, res)
  }

}

