package net.matthaynes.juicer.web

import net.matthaynes.juicer.service._

class ApiServlet extends JsonServlet {

  val MAX_DEFAULT_CONTENT_SIZE = "65535";
  val service = new ArticleExtractorService

  get("/ping")        { Map("message"  -> "pong") }

  get("/article")     { Map("article"  -> service.extract(params("url"), 
                                            params.getOrElse("force_goose", "false").toBoolean, 
                                            params.getOrElse("extract_entities", "true").toBoolean,
                                            params.getOrElse("max_content_size", MAX_DEFAULT_CONTENT_SIZE).toInt )) 
                      }

  post("/article")    { Map("article"  -> service.extract_src(params("url"), params("src"), 
                                            params.getOrElse("force_goose", "false").toBoolean, 
                                            params.getOrElse("extract_entities", "true").toBoolean,
                                            params.getOrElse("max_content_size", MAX_DEFAULT_CONTENT_SIZE).toInt )) 
                      }

  post("/entities")   { Map("entities" -> service.entities.classify(params("text"))) }

}
