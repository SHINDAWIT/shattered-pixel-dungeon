# 1주차_Buffs_정진규

날짜: 2023년 5월 10일 → 2023년 5월 14일
담당자: 정진규
상태: Done🏠
작성자: 정진규
작업유형: ⚒️리팩토링

# Commit Message

> 💬Move Method: Low Cohesion_Lower LOC & Higher Cohesion
>

# 패턴에 대한 설명

> 📌Move method
>

# 수행 이유

> 📌낮은 응집도 유발
>

# 효과

> 💡Method Lines of Code(LOC) 수 줄이기
>
>
> 💡응집도 향상
>

# 수행 대상

> Hero.java(Buff 외 폴더)
>
>
> Buff.java(Buff 안 폴더)
>
# 전/후 비교 다이어그램

> 전
>
>
> ```java
> public void fx(boolean on) {
> 		//do nothing by default
> 	}
> 
> 	~~public String heroMessage(){
> 		String msg = Messages.get(this, "heromsg");
> 		if (msg.isEmpty()) {
> 			return null;
> 		} else {
> 			return msg;
> 		}
> 	}~~
> 
> 	public String name() {
> 		return Messages.get(this, "name");
> 	}
> ```
>

> 후
>
>
> ```java
> public void fx(boolean on) {
> 		//do nothing by default
> 	}
> 
> 	public String name() {
> 		return Messages.get(this, "name");
> 	}
> ```
> 

