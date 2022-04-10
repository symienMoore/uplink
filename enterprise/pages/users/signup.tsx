import cookie from 'js-cookie'
import styles from './styles/signup.module.css';

const Signup = () => {
    // let cookie: any
    // cookie = cookie.get("ExpressGeneratorTs")
    const test = () => {
        cookie.set('test-cookie', 'my test cookie')
        console.log("made it here")
    //     fetch('http://localhost:3000/api/users/all', {
    //         headers: {
    //             'Content-Type': 'text/plain',
    //             'X-My-Custom-Header': 'value-v',
    //             'Authorization': 'ExpressGeneratorTs' + document.cookie,
    //           }
    //       })
    //     .then(response => response.json())
    //     .then(data => console.log(data));
    }
  return (
   <div>
       <form className="w-3/6 px-4 py-3 border-2 border-slate-300 rounded-md">
            <label>Name</label>
            <input type="text" required className="placeholder:italic placeholder:text-slate-400 block bg-white w-full border border-slate-300 rounded-md py-2 pl-9 pr-3 shadow-sm sm:text-sm outline-0" placeholder="full name"/>
            <label>Username</label>
            <input type="text" required className="placeholder:italic placeholder:text-slate-400 block bg-white w-full border border-slate-300 rounded-md py-2 pl-9 pr-3 shadow-sm sm:text-sm outline-0" placeholder="create a username"/>
            <label>Email</label>
            <input type="text" required className="placeholder:italic placeholder:text-slate-400 block bg-white w-full border border-slate-300 rounded-md py-2 pl-9 pr-3 shadow-sm sm:text-sm outline-0" placeholder="ex: someone@example.com"/>
            <label>Password</label>
            <input type="password" required className="placeholder:italic placeholder:text-slate-400 block bg-white w-full border border-slate-300 rounded-md py-2 pl-9 pr-3 shadow-sm sm:text-sm outline-0" placeholder="******"/>
            <label>Confirm password</label>
            <input type="password" required className="placeholder:italic placeholder:text-slate-400 block bg-white w-full border border-slate-300 rounded-md py-2 pl-9 pr-3 shadow-sm sm:text-sm outline-0" placeholder="confirm password"/>
            <div className={styles.buttonContainer}>
                <button className="bg-green-400 text-white p-2">register</button>
                <button onClick={test}>Login</button>
            </div>
       </form>
   </div>
  )
}

export default Signup