package com.arithmetic;

import java.util.Random;

/**
 * author: Administrator
 * create: 2022-02-08 22:16
 * description: n元分为m个红包，最小金额为0.01
 */
public class RedEnvelope {
    public float[] redEnvelope(int n, int m) {
        float[] res = new float[m];
        if(m == 1) {
            res[0] = n;
            return res;
        }

        for(int i = 0; i < m - 1; i++) {
            float currRange = n / (m - i) * 2 - 0.01f;
            float curr = 0.01f + (float) (currRange * Math.random());
            res[i] = (float) Math.floor(curr * 100) / 100;
            n -= res[i];
        }

        res[m - 1] = (float) (Math.round(n * 100)) / 100;
        return res;
    }
}
