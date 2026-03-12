import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        // genresPlaySum, genresSongList 생성
        Map<String, Integer> genresPlaySum = new HashMap<>();
        Map<String, List<Integer>> genresSongList = new HashMap<>();
        
        for(int i=0; i<genres.length; i++) {
            genresPlaySum.put(genres[i], genresPlaySum.getOrDefault(genres[i], 0) + 0);
            
            if(!genresSongList.containsKey(genres[i])) {
                genresSongList.put(genres[i], new ArrayList<>());
            }
            genresSongList.get(genres[i]).add(i);
        }
        
        // 장르별 플레이 순 정렬
        List<String> genresList = new ArrayList<>(genresPlaySum.keySet());
        genresList.sort((a, b) -> Integer.compare(genresPlaySum.get(b), genresPlaySum.get(a)));
        
        // 결과물
        List<Integer> resultList = new ArrayList<>();
        
        for(String genre : genresList) {
            // 장르 속 노래 플레이 순 정렬
            List<Integer> songs = genresSongList.get(genre);

            songs.sort((a, b) -> {
                int compare = Integer.compare(plays[b], plays[a]);
                //장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
                if(compare == 0) return Integer.compare(a, b);
                // 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
                return compare;
            });
            
            for(int i=0; i<Math.min(2, songs.size()); i++) {
                resultList.add(songs.get(i));
            }
        }
        
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}

//스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다. v

//속한 노래가 많이 재생된 장르를 먼저 수록합니다. v
//장르 내에서 많이 재생된 노래를 먼저 수록합니다. v
//장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다. v
//노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.v