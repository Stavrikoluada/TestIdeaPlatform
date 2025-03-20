package com.example.test_idea_platform.data.db

import android.content.Context
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class DatabaseHelper(private val context: Context) {

    private val dbFile = context.getDatabasePath("data")

    fun copyDatabaseFromAssets() {
        if (!dbFile.exists()) {
            try {
                dbFile.parentFile?.mkdirs()

                val inputStream: InputStream = context.assets.open("data.db")
                val outputStream: OutputStream = FileOutputStream(dbFile)

                copyStream(inputStream, outputStream)

                outputStream.flush()
                outputStream.close()
                inputStream.close()

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun copyStream(inputStream: InputStream, outputStream: OutputStream) {
        val buffer = ByteArray(1024)
        var length: Int
        
        while (true) {
            length = inputStream.read(buffer)
            if (length == -1) break
            outputStream.write(buffer, 0, length)
        }
    }
}