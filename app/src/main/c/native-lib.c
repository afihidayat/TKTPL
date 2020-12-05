//
// Created by Aphy on 06/12/2020.
//

#include <jni.h>
#include <stdlib.h>
#include <time.h>


jint Jniint(int input) {
    srand((unsigned int) time(0));
    int intrandom = (rand() % (990 - 101)) + 101;
    return input;
}
JNIEXPORT jint JNICALL
Java_id_ac_ui_cs_mobileprogramming_raflihidayat_lab05_MainActivity_Jniint(JNIEnv* env, jobject this, jint input)
{
return (jint) Jniint(input);
}
