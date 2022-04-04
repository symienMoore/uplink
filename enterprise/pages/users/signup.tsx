import styles from './styles/signup.module.css';

const Signup = () => {
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
                <button>Login</button>
            </div>
       </form>
   </div>
  )
}

export default Signup