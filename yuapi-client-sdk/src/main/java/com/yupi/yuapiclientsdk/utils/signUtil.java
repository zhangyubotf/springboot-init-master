package com.yupi.yuapiclientsdk.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

public  class signUtil {
    public static String gensign(String secreteKey, String body){
        String s = body+"."+secreteKey;
        Digester digester = new Digester(DigestAlgorithm.SHA256);

        return digester.digestHex(s);

    }
}
