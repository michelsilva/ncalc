/*
 * Copyright 2017 Tran Le Duy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.duy.calculator.item_math_type;

import android.content.Context;
import android.util.Log;

import com.example.duy.calculator.R;
import com.example.duy.calculator.math_eval.BigEvaluator;
import com.example.duy.calculator.math_eval.Constants;

/**
 * Created by DUy on 06-Jan-17.
 */

public class PermutationItem extends AExprInput {
    private static final String TAG = PermutationItem.class.getSimpleName();
    protected String numberN = "0";
    protected String numberK = "0";

    public PermutationItem(String n, String k) {
        this.numberN = n;
        this.numberK = k;
    }

    public String getNumberN() {
        return numberN;
    }

    public void setNumberN(String numberN) {
        this.numberN = numberN;
    }

    public String getNumberK() {
        return numberK;
    }

    public void setNumberK(String numberK) {
        this.numberK = numberK;
    }

    @Override
    public boolean isError(BigEvaluator evaluator) {
        try {
            long a1 = Long.parseLong(numberN);
            long a2 = Long.parseLong(numberK);
            boolean b = (a1 > 0 && a2 > 0 && a2 <= a1);
            if (!b) {
                Log.e(TAG, "isError: input error");
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "isError: input error");
            return true;
        }
    }

    @Override
    public String toString() {
        return Constants.P + Constants.LEFT_PAREN + this.numberN + "," + this.numberK
                + Constants.RIGHT_PAREN;
    }

    @Override
    public String getInput() {
        return Constants.P + Constants.LEFT_PAREN + this.numberN + "," + this.numberK
                + Constants.RIGHT_PAREN;
    }

    @Override
    public String getError(BigEvaluator evaluator, Context context) {
        try {
            long a1 = Long.parseLong(numberN);
            long a2 = Long.parseLong(numberK);
            if (a1 < 0 || a2 < 0) return context.getString(R.string.gt_zero);
            else return "";
        } catch (Exception e) {
            e.printStackTrace();
            return context.getString(R.string.not_a_number);
        }
    }
}
