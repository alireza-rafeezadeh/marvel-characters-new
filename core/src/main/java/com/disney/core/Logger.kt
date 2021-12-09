package com.disney.core

class Logger(
    private val tag : String,
    private val isDebug : Boolean = true
) {

    fun log(msg : String) {
        if (!isDebug) {

        } else {
            printLog(tag,msg)
        }
    }

    private fun printLog(tag: String, msg: String) {
        // todo
        println("$tag : $msg" )
    }


    companion object Factory {
        fun buildDebug(tag: String) : Logger {
            return Logger(tag = tag , isDebug = true)
        }

        fun buildRelease(tag: String) : Logger {
            return Logger(tag = tag , isDebug = false)
        }
    }

}