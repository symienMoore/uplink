import '../styles/globals.css'
import type { AppProps } from 'next/app'
import Footer from '../components/footer'
import Header from '../components/header'

function MyApp({ Component, pageProps }: AppProps) {
  return (
    <div>
      <Header />
      <div className="container mx-auto">
        <Component {...pageProps} />
      </div>
    <Footer />
    </div>
  )
}

export default MyApp
