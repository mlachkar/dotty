import scala.quoted._
import scala.language.implicitConversions

object Macro {

  extension (strCtx: => StringContext) implicit inline def f2(args: =>Any*): String = ${FIntepolator.apply('strCtx, 'args)}

}

object FIntepolator {

  def apply(strCtxExpr: Expr[StringContext], argsExpr: Expr[Seq[Any]])(using qctx: QuoteContext) : Expr[String] = {
    import qctx.tasty._
    Reporting.error("there are no parts", strCtxExpr.unseal.underlyingArgument.pos)
    '{ ($strCtxExpr).s($argsExpr: _*) }
  }

}
