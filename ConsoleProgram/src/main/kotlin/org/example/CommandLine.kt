package org.example

import org.kohsuke.args4j.Argument
import org.kohsuke.args4j.CmdLineException
import org.kohsuke.args4j.CmdLineParser
import org.kohsuke.args4j.Option
import java.lang.IllegalArgumentException


class ConsoleProgram {
    @Option(name = "-o", required = false)
    var outputFile: String? = null
    private set
    @Option(name = "-a", required = false)
    var a = 10
    private set
    @Option(name = "-t", required = false)
    var t = false
    private set
    @Option(name = "-r", required = false)
    var r = false
    private set

    @Argument(required = false)
    var nameFile: String? = null
    private set

    fun launch(args: Array<String>) {
        val parser = CmdLineParser(this)
        try {
            parser.parseArgument(args.toMutableList())
        } catch (e: CmdLineException) {
            throw IllegalArgumentException()
        }
    }
}

