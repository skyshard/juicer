resolvers += Classpaths.typesafeResolver

resolvers += "sbt-assembly-resolver-0" at "http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases"

addSbtPlugin("com.typesafe.sbt" % "sbt-start-script" % "0.6.0")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.9.0")
