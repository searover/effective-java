package io.effective._26;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author luxz
 * @date 2020/7/5-9:07 AM
 */
public class WordCount {
    public static void main(String[] args) {
        String[] fc = {"hello world", "hello me", "hello fork", "hello join", "fork join the world"};
        ForkJoinPool fjp = new ForkJoinPool(3);
        MR mr = new MR(fc, 0, fc.length);
        Map<String, Long> result = fjp.invoke(mr);
        result.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
    }

    static class MR extends RecursiveTask<Map<String, Long>> {

        private String[] fc;
        private int start, end;

        public MR(String[] fc, int start, int end) {
            this.fc = fc;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Map<String, Long> compute() {
            System.out.println("compute:" + Thread.currentThread() + ":" + start + ":" + end);
            if (end - start == 1) {
                return calc(fc[start]);
            } else {
                int mid = (start + end) / 2;
                MR mr1 = new MR(fc, start, mid);
                mr1.fork();
                MR mr2 = new MR(fc, mid, end);
                return merge(mr2.compute(), mr1.join());
            }
        }

        // 合并结果
        private Map<String, Long> merge(Map<String, Long> r1, Map<String, Long> r2) {
            Map<String, Long> result = new Hashtable<>();
            result.putAll(r1);
            r2.forEach((k, v) -> {
                Long c = result.get(k);
                if (c != null) {
                    result.put(k, c + v);
                } else {
                    result.put(k, v);
                }
            });
            return result;
        }

        // 统计单词数量
        private Map<String, Long> calc(String line) {
            Map<String, Long> result = new Hashtable<>();
            String[] words = line.split("\\s+");
            for (String word : words) {
                Long v = result.get(word);
                if (v != null) {
                    result.put(word, v + 1);
                } else {
                    result.put(word, 1L);
                }
            }
            return result;
        }
    }
}
