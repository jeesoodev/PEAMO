import "./SignIn.css";
import CloseIcon from "@mui/icons-material/Close";

function SignIn({ toggleSignin }) {
  const REST_API_KEY = "112b52a3500fcf54baac18976074af45";
  const REDIRECT_URI = "http://localhost:3000/callback/kakao";
  const LOGIN_URL = `https://kauth.kakao.com/oauth/authorize?client_id=${REST_API_KEY}&redirect_uri=${REDIRECT_URI}&response_type=code`;

  const kakaoLogin = () => {
    window.location.href = LOGIN_URL;
  };

  return (
    <div className='signin_container'>
      <div className='signin_box'>
        <div className='icon'>
          <div onClick={toggleSignin}>
            <CloseIcon />
          </div>
        </div>
        <h3>PE' AMO</h3>
        <h4>
          당신의 취<span>향</span>을 찾아드립니다.
        </h4>
        <img
          src='/images/kakao_login_medium_narrow.png'
          alt='kakao_login.png'
          onClick={() => kakaoLogin()}
        />
      </div>
    </div>
  );
}

export default SignIn;
