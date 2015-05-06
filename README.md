# A model of a Slider Puzzle game, implemented in Scala.

To try out, run the following command lines (except the '$'s) in a terminal window:

        $ git clone https://github.com/mikost/Slider-Puzzle
        $ cd Slider-Puzzle/
        $ sbt run

If you have 'Sbt' properly installed, the output of the 'sbt run' command should be similar to:

        Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=384M; support was removed in 8.0
        [info] Loading project definition from /home/user/Slider-Puzzle/project
        [info] Updating {file:/home/user/Slider-Puzzle/project/}slider-puzzle-build...
        [info] Resolving org.scala-sbt.ivy#ivy;2.3.0-sbt-fccfbd44c9f64523b61398a0155784d[info] Resolving org.fusesource.jansi#jansi;1.4 ...
        [info] Done updating.
        [info] Set current project to slider-puzzle (in build file:/home/user/Slider-Puzzle/)
        [info] Updating {file:/home/user/Slider-Puzzle/}slider-puzzle...
        [info] Resolving org.fusesource.jansi#jansi;1.4 ...
        [info] Done updating.
        [info] Compiling 1 Scala source to /home/user/Slider-Puzzle/target/scala-2.10/classes...
        [warn] there were 1 feature warning(s); re-run with -feature for details
        [warn] one warning found
        [info] Running com.mikko.sliderpuzzle.Main 
        Move slider 15:
          < 1>< 2>< 3>< 4>
          < 5>< 6>< 7>< 8>
          < 9><10><11><12>
          <13><14><  ><15>

        Move slider 11:
          < 1>< 2>< 3>< 4>
          < 5>< 6>< 7>< 8>
          < 9><10><  ><12>
          <13><14><11><15>

        Move slider 12:
          < 1>< 2>< 3>< 4>
          < 5>< 6>< 7>< 8>
          < 9><10><12><  >
          <13><14><11><15>

        [success] Total time: 4 s, completed May 6, 2015 12:06:54 PM
