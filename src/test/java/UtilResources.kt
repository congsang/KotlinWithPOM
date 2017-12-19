import java.io.FileInputStream
import java.io.IOException
import java.util.*
import java.io.InputStream


class UtilResources {
    companion object {
        private val propFile = "./src/test/java/config.properties"
        private var input: InputStream? = null

        fun getParam(param: String): String {
            val prop = Properties()
            try {
                input = FileInputStream(propFile)
                // load a properties file
                prop.load(input)
            } catch (e: IOException) {
                e.printStackTrace()
            } finally {
                if (input != null) {
                    try {
                        input?.close()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }

                }
            }
            return prop.getProperty(param)
        }
    }
}