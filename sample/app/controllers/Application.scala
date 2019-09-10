package controllers

import javax.inject.Inject

import play.api.mvc._
import models._
import views._
import controllers.stack._
import jp.t2v.lab.play2.stackc.RequestWithAttributes

class Application @Inject() (cc: ControllerComponents) extends AbstractController(cc) with DBSessionElement with LoggingElement {
  
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def messages = StackAction { implicit req =>
    val messages = Message.findAll
    Ok(views.html.messages(messages))
  }

  def editMessage(id: MessageId) = StackAction { implicit req =>
    val messages = Message.findAll
    Ok(views.html.messages(messages))
  }

}
