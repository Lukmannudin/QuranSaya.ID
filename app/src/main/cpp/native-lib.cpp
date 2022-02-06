#include <jni.h>
#include <string>

extern "C"
jstring
Java_com_oleg_quransayaid_common_Keys_getBaseUrlToken(
        JNIEnv *env,
        jobject /* this */) {
    //https://quran-service.herokuapp.com
    std::string baseUrl = "aHR0cHM6Ly9xdXJhbi1zZXJ2aWNlLmhlcm9rdWFwcC5jb20=";
    return env->NewStringUTF(baseUrl.c_str());
}