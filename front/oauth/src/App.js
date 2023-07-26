import { BrowserRouter, Routes, Route } from 'react-router-dom';
import LoginPage from "./LoginPage";
import KakaoRedirectPage from "./KakaoRedirectPage";
import NaverRedirectPage from "./NaverRedirectPage";

const App = () => {
    return (
        <div className='App'>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<LoginPage />}></Route>
                    <Route path="/oauth/redirected/kakao" element={<KakaoRedirectPage />}></Route>
                    <Route path="/oauth/redirected/naver" element={<NaverRedirectPage />}></Route>
                </Routes>
            </BrowserRouter>
        </div>
    );
};

export default App;
