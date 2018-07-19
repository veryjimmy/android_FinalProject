## 一、系統特色
此款【 旅人趴趴照 】為旅遊類型的 app。
主要特色在於能夠查詢台北市各種類型的景點，並且分門別類地將其顯示出來。與別款旅遊 app 最大的不同是【 旅人趴趴照 】多加了旅遊日記功能，讓使用者不但可以查詢哪裡有好玩的地方，還能在去過之後，將這些地點以拍照和日記的方式記錄下來。

## 二、系統設計與實作
【 旅人趴趴照 】的核心內容分為：「景點資訊」、「旅遊日記」、「個人中心」三種頁面，並設有歡迎界面與登陸界面。

#### 1. 歡迎界面
打開app會先進入歡迎界面，如下圖所示。<br/>

![image](https://github.com/veryjimmy/android_FinalProject/blob/master/photo/ex1.png)

#### 2. 登陸界面
在進入登入頁面時，使用者若是第一次使用此程式，需要先進行註冊，註冊完畢後輸入帳號密碼即可登入，若是帳號密碼錯誤則不能登入。
我們利用 SharedPreferences Utils 對帳號密碼進行儲存，這樣離開此程式後想要再次登入的話，不須再註冊，直接輸入之前所註冊的帳號密碼即可，如下圖所示。<br/>

![image](https://github.com/veryjimmy/android_FinalProject/blob/master/photo/ex2.png)
![image](https://github.com/veryjimmy/android_FinalProject/blob/master/photo/ex3.png)

#### 3. 景點資訊
從政府資料開放平台下載旅遊景點資訊進行整理。將整理完畢的 csv 文件導入 Android studio 中進行讀取。使用下拉式選單篩選想要尋找的旅遊景點，再將搜尋結果以清單方式顯現出來。【 旅人趴趴照 】的資料是以台北市的景點為主，因此首先會讓使用者選取要查台北市的哪個區 (ex.中正區,大同區,中山區…)，再來則是篩選觀光景點的類別 (ex.公共藝術、戶外踏青、歷史建築…) ，選取完後下方會列出符合篩選條件的景點以及景點的地址，方便使用者瀏覽，如下圖所示。<br/>

![image](https://github.com/veryjimmy/android_FinalProject/blob/master/photo/ex4.png)
![image](https://github.com/veryjimmy/android_FinalProject/blob/master/photo/ex5.png)
![image](https://github.com/veryjimmy/android_FinalProject/blob/master/photo/ex6.png)<br/>
景點資訊界面(選擇不同景點類型)
![image](https://github.com/veryjimmy/android_FinalProject/blob/master/photo/ex7.png)
![image](https://github.com/veryjimmy/android_FinalProject/blob/master/photo/ex8.png)<br/>

#### 4. 旅遊日記
使用者可以將出遊所想記錄的東西給寫下來，像是今天去了一個好玩的地方，但怕會忘記今天所經歷過的各種新奇事物，這時就可以寫成一篇日記並將此地點給記錄下來，在下方也設置了一個按鈕，讓使用者可以在日記裡匯入照片，這使得旅遊日記不是只有文字而已，還有照片輔助，當使用者想看日記時，還能看到照片，讓平板直敘的文字變得更加生動，如下圖所示。<br/>

![image](https://github.com/veryjimmy/android_FinalProject/blob/master/photo/ex9.png)
![image](https://github.com/veryjimmy/android_FinalProject/blob/master/photo/ex10.png)
![image](https://github.com/veryjimmy/android_FinalProject/blob/master/photo/ex11.png)<br/>

#### 5. 個人中心
儲存著用戶的日記，當使用者想看自己過往的日記時，直接進入「 個人中心 」頁面點擊「 我的日記 」，進入我的日記頁面，就能看到使用者所記錄的每一篇日記。並且點擊任意一篇日記，查看此篇日記的具體內容，如下圖所示。<br/>

![image](https://github.com/veryjimmy/android_FinalProject/blob/master/photo/ex12.png)
![image](https://github.com/veryjimmy/android_FinalProject/blob/master/photo/ex13.png)
![image](https://github.com/veryjimmy/android_FinalProject/blob/master/photo/ex14.png)<br/>
