import sbt._

class ProjectDefinition(info: ProjectInfo) extends DefaultProject(info)
{
  override def libraryDependencies = Set(
    "org.scala-tools.testing" %% "specs" % "1.6.6" % "test->default" withSources()
  ) ++ super.libraryDependencies        
}
