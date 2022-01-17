#include <jni.h>
#include <string>

extern "C"
jstring
Java_com_oleg_quransayaid_common_Keys_getBaseUrlToken(
        JNIEnv* env,
        jobject /* this */) {
        //https://quran-webapi.herokuapp.com
        std::string baseUrl = "aHR0cHM6Ly9xdXJhbi13ZWJhcGkuaGVyb2t1YXBwLmNvbQ==";
        return env->NewStringUTF(baseUrl.c_str());
        }